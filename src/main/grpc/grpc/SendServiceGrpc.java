package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.0)",
    comments = "Source: sample.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SendServiceGrpc {

  private SendServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.SendService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.SampleRequest,
      grpc.SampleResponse> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Send",
      requestType = grpc.SampleRequest.class,
      responseType = grpc.SampleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.SampleRequest,
      grpc.SampleResponse> getSendMethod() {
    io.grpc.MethodDescriptor<grpc.SampleRequest, grpc.SampleResponse> getSendMethod;
    if ((getSendMethod = SendServiceGrpc.getSendMethod) == null) {
      synchronized (SendServiceGrpc.class) {
        if ((getSendMethod = SendServiceGrpc.getSendMethod) == null) {
          SendServiceGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<grpc.SampleRequest, grpc.SampleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SampleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SendServiceMethodDescriptorSupplier("Send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SendServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SendServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SendServiceStub>() {
        @java.lang.Override
        public SendServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SendServiceStub(channel, callOptions);
        }
      };
    return SendServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SendServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SendServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SendServiceBlockingStub>() {
        @java.lang.Override
        public SendServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SendServiceBlockingStub(channel, callOptions);
        }
      };
    return SendServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SendServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SendServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SendServiceFutureStub>() {
        @java.lang.Override
        public SendServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SendServiceFutureStub(channel, callOptions);
        }
      };
    return SendServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SendServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(grpc.SampleRequest request,
        io.grpc.stub.StreamObserver<grpc.SampleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpc.SampleRequest,
                grpc.SampleResponse>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class SendServiceStub extends io.grpc.stub.AbstractAsyncStub<SendServiceStub> {
    private SendServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SendServiceStub(channel, callOptions);
    }

    /**
     */
    public void send(grpc.SampleRequest request,
        io.grpc.stub.StreamObserver<grpc.SampleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SendServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SendServiceBlockingStub> {
    private SendServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SendServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.SampleResponse send(grpc.SampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SendServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SendServiceFutureStub> {
    private SendServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SendServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SendServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.SampleResponse> send(
        grpc.SampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SendServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SendServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((grpc.SampleRequest) request,
              (io.grpc.stub.StreamObserver<grpc.SampleResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SendServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.SampleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SendService");
    }
  }

  private static final class SendServiceFileDescriptorSupplier
      extends SendServiceBaseDescriptorSupplier {
    SendServiceFileDescriptorSupplier() {}
  }

  private static final class SendServiceMethodDescriptorSupplier
      extends SendServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SendServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SendServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SendServiceFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
