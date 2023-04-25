package me.potato.simplerestfulapi.simply

abstract class BaseEntity<ID> {
    open var id: ID? = null
}