package be.ehb.demoormti.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 50)
    private String name;
    private String brand;
    @DecimalMin("0.99")
    private float price;

    @OneToMany(mappedBy = "drink")
    private List<TastingNotes> tastingNotes;

    public Drink() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<TastingNotes> getTastingNotes() {
        return tastingNotes;
    }

    public void setTastingNotes(List<TastingNotes> tastingNotes) {
        this.tastingNotes = tastingNotes;
    }
}
