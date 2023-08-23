package com.testing.firebasespringoauth.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(exclude = "version")
public class BaseEntity {
    @Id
    @Column(nullable = false, length = 36)
    private UUID id = UUID.randomUUID();

    @Version
    private Integer version;

    @CreationTimestamp // https://www.baeldung.com/hibernate-creationtimestamp-updatetimestamp#tracking-the-time-of-last-update-with-updatetimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, nullable = false)
    private Date createdAt;

    // TODO: why not https://www.baeldung.com/hibernate-creationtimestamp-updatetimestamp#tracking-the-time-of-last-update-with-updatetimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;

    // https://www.baeldung.com/hibernate-creationtimestamp-updatetimestamp#caveats
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        lastUpdatedAt = new Date();
    }

    public String toString() {
        return this.getClass().getName()
                + "[id=" + id + "]";
    }
}
