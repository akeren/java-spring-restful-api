package uk.ac.bolton.boltonuniversitybankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    private double balance;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, insertable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", updatable = true)
    private Date updatedAt;

    public Account(Long id, String accountName, double balance) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
    }
}
