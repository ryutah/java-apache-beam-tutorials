package transform.dofn;

import client.Client;
import model.Sample;
import org.apache.beam.sdk.transforms.DoFnTester;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostToClientTest {
    private static class MockClient implements Client {
        private static final long serialVersionUID = 1L;

        private String want;

        public MockClient(String msg) {
            this.want = msg;
        }

        @Override
        public void publish(String message) {
            assertEquals(want, message);
        }
    }

    @Test
    public void post() throws Exception {
        String url = "http://old.com";
        String want = String.format("OLD SITE!\n%s", url);
        MockClient client = new MockClient(want);
        try (DoFnTester<Sample, String> tester = DoFnTester.of(new PostToClient(client))) {
            tester.processBundle(new Sample(url, Sample.Label.OLD.LABEL));
        }
    }
}