/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sijin
 */
@Entity
@Table(name = "model")
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m"),
    @NamedQuery(name = "Model.findByInfo", query = "SELECT m FROM Model m WHERE m.info = :info"),
    @NamedQuery(name = "Model.findByPacketsize", query = "SELECT m FROM Model m WHERE m.packetsize = :packetsize")})
public class Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "info")
    private String info;
    @Column(name = "packetsize")
    private Integer packetsize;

    public Model() {
    }

    public Model(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPacketsize() {
        return packetsize;
    }

    public void setPacketsize(Integer packetsize) {
        this.packetsize = packetsize;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (info != null ? info.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.info == null && other.info != null) || (this.info != null && !this.info.equals(other.info))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Model[info=" + info + "]";
    }

}
