package transform.dofn;

import model.Sample;
import org.apache.beam.sdk.transforms.DoFn;


public class FilterOldOnly extends DoFn<Sample, Sample> {
    @ProcessElement
    public void filter(ProcessContext c) {
        if (c.element().getLabel().equals(Sample.Label.OLD))
            c.output(c.element());
    }
}
