package helper;

import model.Sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHelper {
    public static void assertSample(Sample want, Sample got) {
        assertEquals(want.getUrl(), got.getUrl());
        assertEquals(want.getLabel(), got.getLabel());
    }
}
