package me.potato.simplerestfulapi.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import me.potato.simplerestfulapi.simply.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("account")
data class User(
        @Id override var id: Long? = null,
        @get: NotBlank var name: String? = null,
        @get: Past var dateOfBirth: LocalDate? = null
) : BaseEntity<Long>() {
    val canVote: Boolean
        get() = dateOfBirth?.let { it.isBefore(LocalDate.now().minusYears(18)) } ?: false
}