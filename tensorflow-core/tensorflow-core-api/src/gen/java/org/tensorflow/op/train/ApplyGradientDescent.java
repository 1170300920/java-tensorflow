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

package org.tensorflow.op.train;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.proto.framework.DataType;
import org.tensorflow.types.family.TType;

/**
 * Update '*var' by subtracting 'alpha' * 'delta' from it.
 *
 * @param <T> data type for {@code out} output
 */
@OpMetadata(
    opType = ApplyGradientDescent.OP_NAME,
    inputsClass = ApplyGradientDescent.Inputs.class
)
@Operator(
    group = "train"
)
public final class ApplyGradientDescent<T extends TType> extends RawOp implements Operand<T> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "ApplyGradientDescent";

  private Output<T> out;

  public ApplyGradientDescent(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    out = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new ApplyGradientDescent operation.
   *
   * @param scope current scope
   * @param var Should be from a Variable().
   * @param alpha Scaling factor. Must be a scalar.
   * @param delta The change.
   * @param options carries optional attribute values
   * @param <T> data type for {@code ApplyGradientDescent} output and operands
   * @return a new instance of ApplyGradientDescent
   */
  @Endpoint(
      describeByClass = true
  )
  public static <T extends TType> ApplyGradientDescent<T> create(Scope scope, Operand<T> var,
      Operand<T> alpha, Operand<T> delta, Options... options) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ApplyGradientDescent");
    opBuilder.addInput(var.asOutput());
    opBuilder.addInput(alpha.asOutput());
    opBuilder.addInput(delta.asOutput());
    if (options != null) {
      for (Options opts : options) {
        if (opts.useLocking != null) {
          opBuilder.setAttr("use_locking", opts.useLocking);
        }
      }
    }
    return new ApplyGradientDescent<>(opBuilder.build());
  }

  /**
   * Sets the useLocking option.
   *
   * @param useLocking If {@code True}, the subtraction will be protected by a lock;
   * otherwise the behavior is undefined, but may exhibit less contention.
   * @return this Options instance.
   */
  public static Options useLocking(Boolean useLocking) {
    return new Options().useLocking(useLocking);
  }

  /**
   * Gets out.
   * Same as &quot;var&quot;.
   * @return out.
   */
  public Output<T> out() {
    return out;
  }

  @Override
  public Output<T> asOutput() {
    return out;
  }

  /**
   * Optional attributes for {@link org.tensorflow.op.train.ApplyGradientDescent}
   */
  public static class Options {
    private Boolean useLocking;

    private Options() {
    }

    /**
     * Sets the useLocking option.
     *
     * @param useLocking If {@code True}, the subtraction will be protected by a lock;
     * otherwise the behavior is undefined, but may exhibit less contention.
     * @return this Options instance.
     */
    public Options useLocking(Boolean useLocking) {
      this.useLocking = useLocking;
      return this;
    }
  }

  @OpInputsMetadata(
      outputsClass = ApplyGradientDescent.class
  )
  public static class Inputs<T extends TType> extends RawOpInputs<ApplyGradientDescent<T>> {
    /**
     * Should be from a Variable().
     */
    public final Operand<T> var;

    /**
     * Scaling factor. Must be a scalar.
     */
    public final Operand<T> alpha;

    /**
     * The change.
     */
    public final Operand<T> delta;

    /**
     * The T attribute
     */
    public final DataType T;

    /**
     * If `True`, the subtraction will be protected by a lock;
     * otherwise the behavior is undefined, but may exhibit less contention.
     */
    public final boolean useLocking;

    public Inputs(GraphOperation op) {
      super(new ApplyGradientDescent<>(op), op, Arrays.asList("T", "use_locking"));
      int inputIndex = 0;
      var = (Operand<T>) op.input(inputIndex++);
      alpha = (Operand<T>) op.input(inputIndex++);
      delta = (Operand<T>) op.input(inputIndex++);
      T = op.attributes().getAttrType("T");
      useLocking = op.attributes().getAttrBool("use_locking");
    }
  }
}
