package com.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;

@Slf4j
public abstract class BaseTest {

    public SoftAssertions soft;

    @Before
    public void setup() {
        log.info("Beginning of the test");
        soft = new SoftAssertions();
    }

    @After
    public void tearDown() {
        soft.assertAll();
        log.info("End of the test");
    }
}
