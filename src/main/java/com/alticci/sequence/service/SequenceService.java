package com.alticci.sequence.service;

import static com.alticci.sequence.util.MessageUtils.getMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.alticci.sequence.dto.ResponseDTO;

@Service
public class SequenceService {

	private static final String NUMBER_CANNOT_BE_NULL = "number.cannot.be.null";
	private static final String NUMBER_CANNOT_BE_LESS_THAN_ZERO = "number.cannot.be.less.than.zero";

	@Autowired
	CacheService manager;

	public ResponseEntity<ResponseDTO> calculateAlticciSequence(Long number) {
		this.validateNumber(number);
		Long result = this.calculateUsingCache(number);
		ResponseDTO resp = new ResponseDTO(result);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	private void validateNumber(Long number) {

		if (number == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, getMessage(NUMBER_CANNOT_BE_NULL));
		}
		if (number < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, getMessage(NUMBER_CANNOT_BE_LESS_THAN_ZERO));
		}
	}

	private Long calculateUsingCache(Long number) {
		Long result = manager.get(number);
		if (result == null) {
			result = Long.sum(calculateUsingCache(number - 3), (calculateUsingCache(number - 2)));
			manager.save(number, result);
		}
		return result;
	}

}
