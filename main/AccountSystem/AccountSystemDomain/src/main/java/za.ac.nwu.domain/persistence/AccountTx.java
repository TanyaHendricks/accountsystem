package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TX")
public class AccountTx implements Serializable {

    private static final long serialVersionUID = 3600560805112990945L;

    private Long accountTxId;
    private LocalDate accountTxDate;
    private Float accountTxQuantity;
    private Currency currency;
    private Member  member;

    public AccountTx() {
    }

    public AccountTx(Long accountTxId, LocalDate accountTxDate, Float accountTxQuantity, Currency currency, Member member) {
        this.accountTxId = accountTxId;
        this.accountTxDate = accountTxDate;
        this.accountTxQuantity = accountTxQuantity;
        this.currency = currency;
        this.member = member;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_ID_SEQ", sequenceName =  "ACCOUNT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQ")
    @Column(name = "ACCOUNT_TX_ID")
    public Long getAccountTxId() {
        return accountTxId;
    }

    @Column(name = "ACCOUNT_TX_DATE")
    public LocalDate getAccountTxDate() {
        return accountTxDate;
    }

    @Column(name = "ACCOUNT_TX_QUANTITY")
    public Float getAccountTxQuantity() {
        return accountTxQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENT_ID")
    public Currency getCurrency() { return currency; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember() { return member; }

    public void setAccountTxId(Long accountTxId) {
        this.accountTxId = accountTxId;
    }

    public void setAccountTxDate(LocalDate accountTxDate) {
        this.accountTxDate = accountTxDate;
    }

    public void setAccountTxQuantity(Float accountTxQuantity) {
        this.accountTxQuantity = accountTxQuantity;
    }

    public void setCurrency(Currency currency) { this.currency = currency; }

    public void setMember(Member member) { this.member = member; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTx)) return false;
        AccountTx accountTx = (AccountTx) o;
        return accountTxId.equals(accountTx.accountTxId) && accountTxDate.equals(accountTx.accountTxDate) && accountTxQuantity.equals(accountTx.accountTxQuantity) && currency.equals(accountTx.currency) && member.equals(accountTx.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxId, accountTxDate, accountTxQuantity, currency, member);
    }

    @Override
    public String toString() {
        return "AccountTx{" +
                "accountTxId=" + accountTxId +
                ", accountTxDate=" + accountTxDate +
                ", accountTxQuantity=" + accountTxQuantity +
                ", currency=" + currency +
                ", member=" + member +
                '}';
    }

}
