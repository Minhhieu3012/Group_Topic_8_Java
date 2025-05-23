package ut.edu.database.models;

import ut.edu.database.enums.PropertyStatus;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false, length = 500)
    private String location;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Report> reports;

    @Column(length = 500)
    private String image;

    @ElementCollection
    @CollectionTable(name = "property_room_img", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "img_url")
    private List<String> roomImages = new ArrayList<>(); //anh cac phong ben trong

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyStatus status;
}
