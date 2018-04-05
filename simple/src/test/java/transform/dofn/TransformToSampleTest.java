package transform.dofn;

import helper.TestHelper;
import java.util.Arrays;
import java.util.List;
import model.Sample;
import org.apache.beam.sdk.transforms.DoFnTester;
import org.junit.jupiter.api.Test;

class TransformToSampleTest {
    @Test
    public void testTransform() throws Exception {
        try (DoFnTester<String[], Sample> tester = DoFnTester.of(new TransformToSample())) {
            String[][] data = {
                new String[] {"http://old.com", "old"},
                new String[] {"http://new.com", "new"},
            };
            List<String[]> inputs = Arrays.asList(data);

            List<Sample> want =
                    Arrays.asList(
                            new Sample("http://old.com", Sample.Label.OLD.LABEL),
                            new Sample("http://new.com", Sample.Label.NEW.LABEL));
            List<Sample> got = tester.processBundle(inputs);

            for (int i = 0; i < got.size(); i++) {
                TestHelper.assertSample(want.get(i), got.get(i));
            }
        }
    }
}
