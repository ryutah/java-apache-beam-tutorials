package transform.dofn;

import org.apache.beam.sdk.transforms.DoFnTester;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TransformUppercaseTest {
    @Test
    public void testTransform() throws Exception {
        DoFnTester<String, String> tester = DoFnTester.of(new TransformUppercase());
        String input = "hogehoge";
        List<String> got = tester.processBundle(input);
        List<String> want = Arrays.asList("HOGEHOGE");
        Assert.assertThat(got, CoreMatchers.is(want));
    }
}