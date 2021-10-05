package za.ac.nwu.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {

    private static final long serialVersionUID = 5675005525512587817L;

    private Long memberId;
    private LocalDate memberDate;
    private String memberName;

    private Set<AccountTx> accountTxes;

    public Member() {
    }

    public Member(Long memberId, LocalDate memberDate, String memberName) {
        this.memberId = memberId;
        this.memberDate = memberDate;
        this.memberName = memberName;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_ID_SEQ", sequenceName =  "MEMBER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ID_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "MEMBER_DATE")
    public LocalDate getMemberDate() {
        return memberDate;
    }

    @Column(name = "MEMBER_NAME")
    public String getMemberName() {
        return memberName;
    }

    @OneToMany(targetEntity = AccountTx.class, fetch = FetchType.LAZY, mappedBy = "Currency", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTx> getAccountTxes() { return accountTxes; }

    public void setAccountTxes(Set<AccountTx> accountTxes) {
        this.accountTxes = accountTxes;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return memberId.equals(member.memberId) && memberDate.equals(member.memberDate) && memberName.equals(member.memberName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberDate, memberName);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberDate=" + memberDate +
                ", memberName='" + memberName + '\'' +
                '}';
    }

}
