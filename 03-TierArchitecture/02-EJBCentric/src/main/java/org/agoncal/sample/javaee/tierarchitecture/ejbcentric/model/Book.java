package org.agoncal.sample.javaee.tierarchitecture.ejbcentric.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@XmlRootElement
public class Book implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id = null;

    @Version
    private int version = 0;

    @Column(nullable = false)
    @NotNull
    private String isbn;

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column(length = 2000)
    @Size(max = 2000)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private Float price;
    private Integer nbOfPages;
    private String publisher;
    private Language language;
    private String imageURL;
    private String pageURL;

    @OneToMany
    private Set<Author> authors = new HashSet<>();

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(final Float price) {
        this.price = price;
    }

    public Integer getNbOfPages() {
        return this.nbOfPages;
    }

    public void setNbOfPages(final Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(final Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(final String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPageURL() {
        return this.pageURL;
    }

    public void setPageURL(final String pageURL) {
        this.pageURL = pageURL;
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(final Set<Author> authors) {
        this.authors = authors;
    }

    // =======================================
    // = equals, hashCode & toString Methods =
    // =======================================

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        if (id != null) {
            return id.equals(((Book) that).id);
        }
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (isbn != null && !isbn.trim().isEmpty())
            result += "isbn: " + isbn;
        if (title != null && !title.trim().isEmpty())
            result += ", title: " + title;
        if (description != null && !description.trim().isEmpty())
            result += ", description: " + description;
        if (price != null)
            result += ", price: " + price;
        if (nbOfPages != null)
            result += ", nbOfPages: " + nbOfPages;
        if (publisher != null && !publisher.trim().isEmpty())
            result += ", publisher: " + publisher;
        if (imageURL != null && !imageURL.trim().isEmpty())
            result += ", imageURL: " + imageURL;
        if (pageURL != null && !pageURL.trim().isEmpty())
            result += ", pageURL: " + pageURL;
        return result;
    }
}