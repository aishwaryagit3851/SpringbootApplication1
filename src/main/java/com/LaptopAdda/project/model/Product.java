package com.LaptopAdda.project.model;


import jakarta.persistence.*;


@Entity
public class Product {
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="category_id",referencedColumnName = "category_id")
   private Category category;
    private double price;
    private String processor;
    private String operatingSystem;
    private String osGeneration;
    private String ram;
    private String memory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOsGeneration() {
        return osGeneration;
    }

    public void setOsGeneration(String osGeneration) {
        this.osGeneration = osGeneration;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
