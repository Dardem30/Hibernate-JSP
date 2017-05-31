package by.model;

import javax.persistence.*;

/**
 * Created by УВД on 29.05.2017.
 */
@Entity
@Table(name = "heroes", schema = "hero", catalog = "")
public class HeroesEntity {
    private int idhero;
    private String name;

    @Id
    @Column(name = "idhero")
    public int getIdhero() {
        return idhero;
    }

    public void setIdhero(int idhero) {
        this.idhero = idhero;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroesEntity that = (HeroesEntity) o;

        if (idhero != that.idhero) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idhero;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
