package transform.dofn;

import client.Client;
import model.Sample;
import org.apache.beam.sdk.transforms.DoFn;

public class PostToClient extends DoFn<Sample, String> {
    private Client client;

    public PostToClient(Client client) {
        super();
        this.client = client;
    }

    @ProcessElement
    public void testPost(ProcessContext c) {
        String msg = String.format("OLD SITE!\n%s", c.element().getUrl());
        this.client.publish(msg);
        c.output(msg);
    }
}
