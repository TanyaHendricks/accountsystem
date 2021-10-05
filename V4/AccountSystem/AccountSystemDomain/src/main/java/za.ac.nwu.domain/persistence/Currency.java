package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {

    private static final long serialVersionUID = 7572573248076011568L;

    private Long currencyId;
    private LocalDate currencyCreationDate;
    private String currencyName;
    private String currencyDescription;

    private Set<AccountTx> accountCurTxes;
    private Set<AccountTx> accountMemTxes;

    public Currency() {
    }

    public Currency(Long currencyId, LocalDate currencyCreationDate, String currencyName, String currencyDescription) {
        this.currencyId = currencyId;
        this.currencyCreationDate = currencyCreationDate;
        this.currencyName = currencyName;
        this.currencyDescription = currencyDescription;
    }

    @Id
    @SequenceGenerator(name = "CURRENCY_ID_SEQ", sequenceName = "CURRENCY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY_ID_SEQ")
    @Column(name = "CURRENCY_ID")
    public Long getCurrencyId() {
        return currencyId;
    }

    @Column(name = "CURRENCY_CREATION_DATE")
    public LocalDate getCurrencyCreationDate() {
        return currencyCreationDate;
    }

    @Column(name = "CURRENCY_NAME")
    public String getCurrencyName() {
        return currencyName;
    }

    @Column(name = "CURRENCY_DESCRIPTION")
    public String getCurrencyDescription() {
        return currencyDescription;
    }

    @OneToMany(targetEntity = AccountTx.class, fetch = FetchType.LAZY, mappedBy = "Currency", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTx> getAccountCurTxes() { return accountCurTxes; }

    @OneToMany(targetEntity = AccountTx.class, fetch = FetchType.LAZY, mappedBy = "Member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTx> getAccountMemTxes() { return accountMemTxes; }

    public void setAccountCurTxes(Set<AccountTx> accountCurTxes) {
        this.accountCurTxes = accountCurTxes;
    }

    public void setAccountMemTxes(Set<AccountTx> accountMemTxes) {
        this.accountMemTxes = accountMemTxes;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyCreationDate(LocalDate currencyCreationDate) {
        this.currencyCreationDate = currencyCreationDate;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return currencyId.equals(currency.currencyId) && currencyCreationDate.equals(currency.currencyCreationDate) && currencyName.equals(currency.currencyName) && currencyDescription.equals(currency.currencyDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyId, currencyCreationDate, currencyName, currencyDescription);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId=" + currencyId +
                ", currencyCreationDate=" + currencyCreationDate +
                ", currencyName='" + currencyName + '\'' +
                ", currencyDescription='" + currencyDescription + '\'' +
                '}';
    }

}
