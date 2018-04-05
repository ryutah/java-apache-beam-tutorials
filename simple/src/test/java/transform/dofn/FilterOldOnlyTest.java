package transform.dofn;

import helper.TestHelper;
import model.Sample;
import org.apache.beam.sdk.transforms.DoFnTester;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FilterOldOnlyTest {
    @Test
    public void testFilter() throws Exception {
        try (DoFnTester<Sample, Sample> tester = DoFnTester.of(new FilterOldOnly())) {
            List<Sample> input = Arrays.asList(
                    new Sample("http://old.com", Sample.Label.OLD.LABEL),
                    new Sample("http://new.com", Sample.Label.NEW.LABEL)
            );
            List<Sample> got = tester.processBundle(input);
            List<Sample> want = Arrays.asList(
                    new Sample("http://old.com", Sample.Label.OLD.LABEL)
            );
            for (int i = 0; i < got.size(); i++) {
                TestHelper.assertSample(want.get(i), got.get(i));
            }
        }
    }
}