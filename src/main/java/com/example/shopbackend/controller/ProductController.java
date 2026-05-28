@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return productRepository.findAll(
                PageRequest.of(page, size)
        );
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {

        return productRepository.findById(id)
                .orElseThrow();
    }

    @GetMapping("/search")
    public List<Product> search(
            @RequestParam String keyword) {

        return productRepository.findByNameContaining(keyword);
    }
}