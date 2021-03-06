package kr.codesquad.library.domain.book;

import kr.codesquad.library.domain.category.Category;
import kr.codesquad.library.domain.rental.Rental;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;

    @Column(length = 2048)
    private String description;
    private String author;
    private String publisher;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    private String isbn;

    @Column(name = "out_of_stock")
    private boolean outOfStock;

    @Column(name = "recommend_count")
    private int recommendCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Rental> rentals = new ArrayList<>();

    @Builder
    private Book(Long id, String title, String description, String author, String publisher,
                 LocalDate publicationDate, String imageUrl, String isbn, boolean outOfStock, int recommendCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.imageUrl = imageUrl;
        this.isbn = isbn;
        this.outOfStock = outOfStock;
        this.recommendCount = recommendCount;
    }

    public void setCategoryToTest(Category category) {
        this.category = category;
    }
}
