package com.alticci.sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alticci.sequence.dto.ResponseDTO;
import com.alticci.sequence.service.SequenceService;

@RestController
@RequestMapping("/alticci")
public class SequenceController {

	@Autowired
	private SequenceService sequenceService;

	@CrossOrigin
	@GetMapping("/{n}")
	public ResponseEntity<ResponseDTO> calculateAlticciSequence(@PathVariable("n") Long number) {
		return sequenceService.calculateAlticciSequence(number);
	}

}
