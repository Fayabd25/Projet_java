@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @PostMapping("/products")
    public Product createProduct(
            @RequestBody Product product) {

        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product existing = productRepository.findById(id)
                .orElseThrow();

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setDescription(product.getDescription());

        return productRepository.save(existing);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productRepository.deleteById(id);

        return "Produit supprimé";
    }

    @GetMapping("/users")
    public List<User> users() {

        return userRepository.findAll();
    }
}