package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "EX_RATE")
public class ExRate implements Serializable {

    private static final long serialVersionUID = -6524075002185179136L;

    private Long exRateId;
    private LocalDate Ex_Rate_Date;
    private Float Ex_Rate;
    private Currency currencyBase;
    private Currency currency;

    public ExRate() {
    }

    public ExRate(Long exRateId, LocalDate ex_Rate_Date, Float ex_Rate, Currency currencyBase, Currency currency) {
        this.exRateId = exRateId;
        Ex_Rate_Date = ex_Rate_Date;
        Ex_Rate = ex_Rate;
        this.currencyBase = currencyBase;
        this.currency = currency;
    }

    @Id
    @SequenceGenerator(name = "EX_RATE_ID_SEQ", sequenceName = "EX_RATE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EX_RATE_ID_SEQ")
    @Column(name = "EX_RATE_ID")
    public Long getExRateId() {
        return exRateId;
    }

    @Column(name = "EX_RATE_DATE")
    public LocalDate getEx_Rate_Date() {
        return Ex_Rate_Date;
    }

    @Column(name = "EX_RATE")
    public Float getEx_Rate() {
        return Ex_Rate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENT_ID_BASE")
    public Currency getCurrencyBase() {
        return currencyBase;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENT_ID")
    public Currency getCurrency() {
        return currency;
    }

    public void setExRateId(Long exRateId) {
        this.exRateId = exRateId;
    }

    public void setEx_Rate_Date(LocalDate ex_Rate_Date) {
        Ex_Rate_Date = ex_Rate_Date;
    }

    public void setEx_Rate(Float ex_Rate) {
        Ex_Rate = ex_Rate;
    }

    public void setCurrencyBase(Currency currencyBase) {
        this.currencyBase = currencyBase;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExRate)) return false;
        ExRate exRate = (ExRate) o;
        return exRateId.equals(exRate.exRateId) && Ex_Rate_Date.equals(exRate.Ex_Rate_Date) && Ex_Rate.equals(exRate.Ex_Rate) && currencyBase.equals(exRate.currencyBase) && currency.equals(exRate.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exRateId, Ex_Rate_Date, Ex_Rate, currencyBase, currency);
    }

    @Override
    public String toString() {
        return "ExRate{" +
                "exRateId=" + exRateId +
                ", Ex_Rate_Date=" + Ex_Rate_Date +
                ", Ex_Rate=" + Ex_Rate +
                ", currencyBase=" + currencyBase +
                ", currency=" + currency +
                '}';
    }

}
