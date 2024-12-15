package service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: ProductReviewService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductReviewServiceGrpc {

  private ProductReviewServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "service.ProductReviewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.AddReviewRequest,
      service.ProductReviewServiceOuterClass.AddReviewResponse> getAddReviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddReview",
      requestType = service.ProductReviewServiceOuterClass.AddReviewRequest.class,
      responseType = service.ProductReviewServiceOuterClass.AddReviewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.AddReviewRequest,
      service.ProductReviewServiceOuterClass.AddReviewResponse> getAddReviewMethod() {
    io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.AddReviewRequest, service.ProductReviewServiceOuterClass.AddReviewResponse> getAddReviewMethod;
    if ((getAddReviewMethod = ProductReviewServiceGrpc.getAddReviewMethod) == null) {
      synchronized (ProductReviewServiceGrpc.class) {
        if ((getAddReviewMethod = ProductReviewServiceGrpc.getAddReviewMethod) == null) {
          ProductReviewServiceGrpc.getAddReviewMethod = getAddReviewMethod =
              io.grpc.MethodDescriptor.<service.ProductReviewServiceOuterClass.AddReviewRequest, service.ProductReviewServiceOuterClass.AddReviewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddReview"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.AddReviewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.AddReviewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductReviewServiceMethodDescriptorSupplier("AddReview"))
              .build();
        }
      }
    }
    return getAddReviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetReviewsRequest,
      service.ProductReviewServiceOuterClass.GetReviewsResponse> getGetReviewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReviews",
      requestType = service.ProductReviewServiceOuterClass.GetReviewsRequest.class,
      responseType = service.ProductReviewServiceOuterClass.GetReviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetReviewsRequest,
      service.ProductReviewServiceOuterClass.GetReviewsResponse> getGetReviewsMethod() {
    io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetReviewsRequest, service.ProductReviewServiceOuterClass.GetReviewsResponse> getGetReviewsMethod;
    if ((getGetReviewsMethod = ProductReviewServiceGrpc.getGetReviewsMethod) == null) {
      synchronized (ProductReviewServiceGrpc.class) {
        if ((getGetReviewsMethod = ProductReviewServiceGrpc.getGetReviewsMethod) == null) {
          ProductReviewServiceGrpc.getGetReviewsMethod = getGetReviewsMethod =
              io.grpc.MethodDescriptor.<service.ProductReviewServiceOuterClass.GetReviewsRequest, service.ProductReviewServiceOuterClass.GetReviewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReviews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.GetReviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.GetReviewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductReviewServiceMethodDescriptorSupplier("GetReviews"))
              .build();
        }
      }
    }
    return getGetReviewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetAverageRatingRequest,
      service.ProductReviewServiceOuterClass.GetAverageRatingResponse> getGetAverageRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAverageRating",
      requestType = service.ProductReviewServiceOuterClass.GetAverageRatingRequest.class,
      responseType = service.ProductReviewServiceOuterClass.GetAverageRatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetAverageRatingRequest,
      service.ProductReviewServiceOuterClass.GetAverageRatingResponse> getGetAverageRatingMethod() {
    io.grpc.MethodDescriptor<service.ProductReviewServiceOuterClass.GetAverageRatingRequest, service.ProductReviewServiceOuterClass.GetAverageRatingResponse> getGetAverageRatingMethod;
    if ((getGetAverageRatingMethod = ProductReviewServiceGrpc.getGetAverageRatingMethod) == null) {
      synchronized (ProductReviewServiceGrpc.class) {
        if ((getGetAverageRatingMethod = ProductReviewServiceGrpc.getGetAverageRatingMethod) == null) {
          ProductReviewServiceGrpc.getGetAverageRatingMethod = getGetAverageRatingMethod =
              io.grpc.MethodDescriptor.<service.ProductReviewServiceOuterClass.GetAverageRatingRequest, service.ProductReviewServiceOuterClass.GetAverageRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAverageRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.GetAverageRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.ProductReviewServiceOuterClass.GetAverageRatingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductReviewServiceMethodDescriptorSupplier("GetAverageRating"))
              .build();
        }
      }
    }
    return getGetAverageRatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductReviewServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceStub>() {
        @java.lang.Override
        public ProductReviewServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductReviewServiceStub(channel, callOptions);
        }
      };
    return ProductReviewServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductReviewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceBlockingStub>() {
        @java.lang.Override
        public ProductReviewServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductReviewServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductReviewServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductReviewServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductReviewServiceFutureStub>() {
        @java.lang.Override
        public ProductReviewServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductReviewServiceFutureStub(channel, callOptions);
        }
      };
    return ProductReviewServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Bewertet ein Produkt hinzufügen
     * </pre>
     */
    default void addReview(service.ProductReviewServiceOuterClass.AddReviewRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.AddReviewResponse> responseObserver) throws IOException, ParseException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddReviewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Holt alle Bewertungen für ein Produkt
     * </pre>
     */
    default void getReviews(service.ProductReviewServiceOuterClass.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetReviewsResponse> responseObserver) throws IOException, ParseException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReviewsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Berechnet das durchschnittliche Rating für ein Produkt
     * </pre>
     */
    default void getAverageRating(service.ProductReviewServiceOuterClass.GetAverageRatingRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetAverageRatingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAverageRatingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductReviewService.
   */
  public static abstract class ProductReviewServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductReviewServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductReviewService.
   */
  public static final class ProductReviewServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductReviewServiceStub> {
    private ProductReviewServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bewertet ein Produkt hinzufügen
     * </pre>
     */
    public void addReview(service.ProductReviewServiceOuterClass.AddReviewRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.AddReviewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddReviewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Holt alle Bewertungen für ein Produkt
     * </pre>
     */
    public void getReviews(service.ProductReviewServiceOuterClass.GetReviewsRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetReviewsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReviewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Berechnet das durchschnittliche Rating für ein Produkt
     * </pre>
     */
    public void getAverageRating(service.ProductReviewServiceOuterClass.GetAverageRatingRequest request,
        io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetAverageRatingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAverageRatingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductReviewService.
   */
  public static final class ProductReviewServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductReviewServiceBlockingStub> {
    private ProductReviewServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bewertet ein Produkt hinzufügen
     * </pre>
     */
    public service.ProductReviewServiceOuterClass.AddReviewResponse addReview(service.ProductReviewServiceOuterClass.AddReviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddReviewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Holt alle Bewertungen für ein Produkt
     * </pre>
     */
    public service.ProductReviewServiceOuterClass.GetReviewsResponse getReviews(service.ProductReviewServiceOuterClass.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReviewsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Berechnet das durchschnittliche Rating für ein Produkt
     * </pre>
     */
    public service.ProductReviewServiceOuterClass.GetAverageRatingResponse getAverageRating(service.ProductReviewServiceOuterClass.GetAverageRatingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAverageRatingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductReviewService.
   */
  public static final class ProductReviewServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductReviewServiceFutureStub> {
    private ProductReviewServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductReviewServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductReviewServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bewertet ein Produkt hinzufügen
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<service.ProductReviewServiceOuterClass.AddReviewResponse> addReview(
        service.ProductReviewServiceOuterClass.AddReviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddReviewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Holt alle Bewertungen für ein Produkt
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<service.ProductReviewServiceOuterClass.GetReviewsResponse> getReviews(
        service.ProductReviewServiceOuterClass.GetReviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReviewsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Berechnet das durchschnittliche Rating für ein Produkt
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<service.ProductReviewServiceOuterClass.GetAverageRatingResponse> getAverageRating(
        service.ProductReviewServiceOuterClass.GetAverageRatingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAverageRatingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_REVIEW = 0;
  private static final int METHODID_GET_REVIEWS = 1;
  private static final int METHODID_GET_AVERAGE_RATING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_REVIEW:
          try {
            serviceImpl.addReview((ProductReviewServiceOuterClass.AddReviewRequest) request,
                (io.grpc.stub.StreamObserver<ProductReviewServiceOuterClass.AddReviewResponse>) responseObserver);
          } catch (IOException e) {
            throw new RuntimeException(e);
          } catch (ParseException e) {
            throw new RuntimeException(e);
          }
          break;
        case METHODID_GET_REVIEWS:
          serviceImpl.getReviews((service.ProductReviewServiceOuterClass.GetReviewsRequest) request,
              (io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetReviewsResponse>) responseObserver);
          break;
        case METHODID_GET_AVERAGE_RATING:
          serviceImpl.getAverageRating((service.ProductReviewServiceOuterClass.GetAverageRatingRequest) request,
              (io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetAverageRatingResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddReviewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              service.ProductReviewServiceOuterClass.AddReviewRequest,
              service.ProductReviewServiceOuterClass.AddReviewResponse>(
                service, METHODID_ADD_REVIEW)))
        .addMethod(
          getGetReviewsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              service.ProductReviewServiceOuterClass.GetReviewsRequest,
              service.ProductReviewServiceOuterClass.GetReviewsResponse>(
                service, METHODID_GET_REVIEWS)))
        .addMethod(
          getGetAverageRatingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              service.ProductReviewServiceOuterClass.GetAverageRatingRequest,
              service.ProductReviewServiceOuterClass.GetAverageRatingResponse>(
                service, METHODID_GET_AVERAGE_RATING)))
        .build();
  }

  private static abstract class ProductReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductReviewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProductReviewServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductReviewService");
    }
  }

  private static final class ProductReviewServiceFileDescriptorSupplier
      extends ProductReviewServiceBaseDescriptorSupplier {
    ProductReviewServiceFileDescriptorSupplier() {}
  }

  private static final class ProductReviewServiceMethodDescriptorSupplier
      extends ProductReviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductReviewServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductReviewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductReviewServiceFileDescriptorSupplier())
              .addMethod(getAddReviewMethod())
              .addMethod(getGetReviewsMethod())
              .addMethod(getGetAverageRatingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
