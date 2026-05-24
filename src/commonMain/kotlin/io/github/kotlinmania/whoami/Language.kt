// port-lint: source language.rs
package io.github.kotlinmania.whoami

/**
 * Country code for a [Language] dialect.
 *
 * Uses ISO 3166-1 alpha-2.
 */
public enum class Country {
    // FIXME: V2: use integer bytes for country codes, with null bytes for unused positions.
    // FIXME: Add aliases up to 3-4 letters, but hidden.
    /**
     * Any dialect.
     */
    Any,

    /**
     * `US`: United States of America.
     */
    Us,
    ;

    private fun fmt(): String =
        when (this) {
            Any -> "**"
            Us -> "US"
        }

    override fun toString(): String = fmt()
}

/**
 * A spoken language.
 *
 * Use [toString] to convert to a string of a two-letter lowercase language code
 * followed by a slash and uppercase country code, for example `en/US`.
 *
 * Language codes are defined in ISO 639, and country codes are defined in ISO 3166.
 */
public sealed class Language {
    /**
     * Custom language code.
     */
    public data class Custom(public val code: String) : Language()

    /**
     * `en`: English.
     */
    public data class En(public val country: Country) : Language()

    /**
     * `es`: Spanish.
     */
    public data class Es(public val country: Country) : Language()

    /**
     * Retrieve the country code for this language dialect.
     */
    public fun country(): Country =
        when (this) {
            is Custom -> Country.Any
            is En -> country
            is Es -> country
        }

    private fun fmt(): String =
        when (this) {
            is Custom -> code
            is En ->
                if (country != Country.Any) {
                    "en/$country"
                } else {
                    "en"
                }

            is Es ->
                if (country != Country.Any) {
                    "es/$country"
                } else {
                    "es"
                }
        }

    final override fun toString(): String = fmt()
}
