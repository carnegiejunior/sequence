package com.alticci.sequence.service;

import static com.alticci.sequence.util.MessageUtils.getMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import com.alticci.sequence.AlticciSequenceApplication;
import com.alticci.sequence.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;


@ActiveProfiles("test")
@SpringBootTest(classes = AlticciSequenceApplication.class)
class SequenceServiceTest {
	
	private static final String NUMBER_CANNOT_BE_NULL = "number.cannot.be.null";
	private static final String NUMBER_CANNOT_BE_LESS_THAN_ZERO = "number.cannot.be.less.than.zero";

    @Autowired
    private SequenceService service;


    @Test
    void calculateAlticciSequenceSuccess() throws JsonProcessingException {
        // setup
    	List<Long> numbers = Arrays.asList(0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 10l);
    	List<Long> expected = Arrays.asList(0l, 1l, 1l, 1l, 2l, 2l, 3l, 4l, 5l, 7l, 9l);
    	List<Long> results = new ArrayList<>();

        // run
    	numbers.forEach(n -> {
    		ResponseEntity<ResponseDTO> response = this.service.calculateAlticciSequence(n);
    		results.add(response.getBody().getResult());
    	});

        // validate
        assertEquals(expected, results);
    }


    @Test
	void calculateAlticciSequenceException() {
		// run exception scenario
    	ResponseStatusException exNull = assertThrows(ResponseStatusException.class, () -> {
			this.service.calculateAlticciSequence(null);
		});
    	
    	ResponseStatusException exNegativeValue = assertThrows(ResponseStatusException.class, () -> {
			this.service.calculateAlticciSequence(-1l);
		});

		// validate
		assertEquals(getMessage(NUMBER_CANNOT_BE_NULL), exNull.getReason());
		assertEquals(getMessage(NUMBER_CANNOT_BE_LESS_THAN_ZERO), exNegativeValue.getReason());
	}
}
