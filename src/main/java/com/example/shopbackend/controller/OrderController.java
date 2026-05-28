@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @PostMapping
    public Order createOrder(
            @RequestBody OrderRequest request,
            Authentication authentication) {

        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        Product product = productRepository
                .findById(request.getProductId())
                .orElseThrow();

        Order order = new Order();

        order.setUser(user);
        order.setProduit(product);
        order.setQuantite(request.getQuantite());

        order.setTotalAmount(
                product.getPrice() * request.getQuantite()
        );

        order.setStatus(OrderStatus.PENDING);

        return orderRepository.save(order);
    }

    @GetMapping("/my-orders")
    public List<Order> myOrders(Authentication authentication) {

        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        return orderRepository.findByUser(user);
    }
}