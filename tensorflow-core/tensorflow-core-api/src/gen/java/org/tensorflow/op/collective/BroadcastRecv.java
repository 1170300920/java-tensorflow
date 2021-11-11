/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.collective;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.op.Operands;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.proto.framework.DataType;
import org.tensorflow.types.family.TType;

/**
 * Receives a tensor value broadcast from another device.
 *
 * @param <T> data type for {@code data} output
 */
@OpMetadata(
    opType = BroadcastRecv.OP_NAME,
    inputsClass = BroadcastRecv.Inputs.class
)
public final class BroadcastRecv<T extends TType> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "CollectiveBcastRecv";

  private Output<T> data;

  public BroadcastRecv(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    data = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new CollectiveBcastRecv operation.
   *
   * @param scope current scope
   * @param T The value of the T attribute
   * @param groupSize The value of the groupSize attribute
   * @param groupKey The value of the groupKey attribute
   * @param instanceKey The value of the instanceKey attribute
   * @param shape The value of the shape attribute
   * @param options carries optional attribute values
   * @param <T> data type for {@code CollectiveBcastRecv} output and operands
   * @return a new instance of BroadcastRecv
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> BroadcastRecv<T> create(Scope scope, Class<T> T, Long groupSize,
      Long groupKey, Long instanceKey, Shape shape, Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "BroadcastRecv");
    opBuilder.setAttr("T", Operands.toDataType(T));
    opBuilder.setAttr("group_size", groupSize);
    opBuilder.setAttr("group_key", groupKey);
    opBuilder.setAttr("instance_key", instanceKey);
    opBuilder.setAttr("shape", shape);
    if (options != null) {
      for (Options opts : options) {
        if (opts.communicationHint != null) {
          opBuilder.setAttr("communication_hint", opts.communicationHint);
        }
        if (opts.timeoutSeconds != null) {
          opBuilder.setAttr("timeout_seconds", opts.timeoutSeconds);
        }
      }
    }
    return new BroadcastRecv<>(opBuilder.build());
  }

  /**
   * Sets the communicationHint option.
   *
   * @param communicationHint the communicationHint option
   * @return this Options instance.
   */
  public static Options communicationHint(String communicationHint) {
    return new Options().communicationHint(communicationHint);
  }

  /**
   * Sets the timeoutSeconds option.
   *
   * @param timeoutSeconds the timeoutSeconds option
   * @return this Options instance.
   */
  public static Options timeoutSeconds(Float timeoutSeconds) {
    return new Options().timeoutSeconds(timeoutSeconds);
  }

  /**
   * Gets data.
   *
   * @return data.
   */
  public Output<T> data() {
    return data;
  }

  @Override
  public Output<T> asOutput() {
    return data;
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.collective.BroadcastRecv}
   */
  public static class Options {
    private String communicationHint;

    private Float timeoutSeconds;

    private Options() {
    }

    /**
     * Sets the communicationHint option.
     *
     * @param communicationHint the communicationHint option
     * @return this Options instance.
     */
    public Options communicationHint(String communicationHint) {
      this.communicationHint = communicationHint;
      return this;
    }

    /**
     * Sets the timeoutSeconds option.
     *
     * @param timeoutSeconds the timeoutSeconds option
     * @return this Options instance.
     */
    public Options timeoutSeconds(Float timeoutSeconds) {
      this.timeoutSeconds = timeoutSeconds;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = BroadcastRecv.class
  )
  public static class Inputs extends RawOpInputs<BroadcastRecv<?>> {
    /**
     * The T attribute
     */
    public final DataType T;

    /**
     * The groupSize attribute
     */
    public final long groupSize;

    /**
     * The groupKey attribute
     */
    public final long groupKey;

    /**
     * The instanceKey attribute
     */
    public final long instanceKey;

    /**
     * The shape attribute
     */
    public final Shape shape;

    /**
     * The communicationHint attribute
     */
    public final String communicationHint;

    /**
     * The timeoutSeconds attribute
     */
    public final float timeoutSeconds;

    public Inputs(GraphOperation op) {
      super(new BroadcastRecv<>(op), op, Arrays.asList("T", "group_size", "group_key", "instance_key", "shape", "communication_hint", "timeout_seconds"));
      int inputIndex = 0;
      T = op.attributes().getAttrType("T");
      groupSize = op.attributes().getAttrInt("group_size");
      groupKey = op.attributes().getAttrInt("group_key");
      instanceKey = op.attributes().getAttrInt("instance_key");
      shape = op.attributes().getAttrShape("shape");
      communicationHint = op.attributes().getAttrString("communication_hint");
      timeoutSeconds = op.attributes().getAttrFloat("timeout_seconds");
    }
  }
}
