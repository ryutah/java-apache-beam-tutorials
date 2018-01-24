package transform.dofn;

import org.apache.beam.sdk.transforms.DoFn;

public class TransformUppercase extends DoFn<String, String> {
    @ProcessElement
    public void transform(ProcessContext c) {
        c.output(c.element().toUpperCase());
    }
}
