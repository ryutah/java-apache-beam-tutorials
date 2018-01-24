package transform.dofn;

import model.Sample;
import org.apache.beam.sdk.transforms.DoFn;

public class TransformToSample extends DoFn<String[], Sample> {
    @ProcessElement
    public void transform(ProcessContext c) {
        String[] strs = c.element();
        if (strs.length < 2) {
            return;
        }
        Sample sample = new Sample(strs[0], strs[1]);
        c.output(sample);
    }
}
