package com.streamsets.pipeline.lib.stage.devtest;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.ChooserValues;

import java.util.ArrayList;
import java.util.List;

public class ConverterValuesProvider implements ChooserValues {
    @Override
    public List<String> getValues() {
      List<String> values = new ArrayList<String>();
      for (Field.Type type : Field.Type.values()) {
        values.add(type.toString());
      }
      return values;
    }

    @Override
    public List<String> getLabels() {
      List<String> labels = new ArrayList<String>();
      for (Field.Type type : Field.Type.values()) {
        labels.add(type.name());
      }
      return labels;
    }
  }