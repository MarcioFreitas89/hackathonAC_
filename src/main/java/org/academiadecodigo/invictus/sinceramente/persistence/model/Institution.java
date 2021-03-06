package org.academiadecodigo.invictus.sinceramente.persistence.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "institution")
public class Institution extends AbstractModel{

    private String name;
    private String address;
    private String siteUrl;
    private String email;
    private String description;
    private Integer rate;

    @OneToMany(
            cascade =  {CascadeType.ALL},

            orphanRemoval = false,

            mappedBy = "institution",

            fetch = FetchType.LAZY
    )
    private List<Rating> ratings = new LinkedList<>();



    @OneToMany(
            cascade =  {CascadeType.ALL},

            orphanRemoval = false,

            mappedBy = "institution",

            fetch = FetchType.LAZY
    )
    private List<Donation> donations = new LinkedList<>();

  /*  @OneToMany(
            cascade =  {CascadeType.ALL},
            cascade = {CascadeType.ALL},

            orphanRemoval = true,

            mappedBy = "institution",

            fetch = FetchType.LAZY
    )*/

    public void addDonation(Donation donation) {
        donations.add(donation);
        donation.setInstitution(this);
    }

    public void removeDonation(Donation donation) {
        donations.remove(donation);
        donation.setInstitution(null);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setInstitution(this);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setInstitution(null);
    }
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
