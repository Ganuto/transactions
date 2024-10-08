package com.project.transactions.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "account_id", nullable = false)
  private Long accountId;

  @Enumerated
  @Column(name = "operation_type_id", nullable = false)
  private OperationType operationType;

  @Column(name = "amount", nullable = false)
  private BigDecimal amount;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "event_date")
  private LocalDateTime eventDate;
}
