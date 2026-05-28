@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;

    private String lienImage;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Category category;
}