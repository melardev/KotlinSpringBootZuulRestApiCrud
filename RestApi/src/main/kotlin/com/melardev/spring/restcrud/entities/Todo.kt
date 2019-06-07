package com.melardev.spring.restcrud.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = -1,
        var title: String = "",
        var createdAt: LocalDateTime? = null,
        var updatedAt: LocalDateTime? = null,
        var isCompleted: Boolean = false
) {

    // To avoid Caused by: org.h2.jdbc.JdbcSQLException: Value too long for column "DESCRIPTION VARCHAR(255)
    @Lob
    var description: String? = null

    constructor(title: String, description: String?, completed: Boolean, createdAt: LocalDateTime?, updatedAt: LocalDateTime?)
            : this(-1, title, createdAt, updatedAt, completed) {
        this.title = title
        this.description = description
    }

    @JvmOverloads
    constructor(title: String, description: String, completed: Boolean = false)
            : this(title, description, completed, null, null)

    constructor(id: Long, title: String, completed: Boolean, createdAt: LocalDateTime, updatedAt: LocalDateTime)
            : this(id, title, createdAt, updatedAt, completed)


    @PrePersist
    fun preSave() {
        if (this.createdAt == null) {
            createdAt = LocalDateTime.now()
        }
        if (this.updatedAt == null)
            updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}