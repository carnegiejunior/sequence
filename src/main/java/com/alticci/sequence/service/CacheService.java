package com.alticci.sequence.service;

import static com.alticci.sequence.util.MessageUtils.getMessage;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import jakarta.annotation.PostConstruct;

@Component
@ApplicationScope
public class CacheService {

	private static final String NUMBER_CANNOT_BE_NULL = "number.cannot.be.null";
	final Map<Long, Long> cache = new HashMap<>();

	public void save(Long index, Long value) {
		cache.put(index, value);
	}

	public Long get(Long index) {
		return cache.get(Optional.ofNullable(index).orElseThrow(() -> new InvalidParameterException(getMessage(NUMBER_CANNOT_BE_NULL))));
	}

	@PostConstruct
	void startUp() {
		cache.put(0l, 0l);
		cache.put(1l, 1l);
		cache.put(2l, 1l);
	}

}
