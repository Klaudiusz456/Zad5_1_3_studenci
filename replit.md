# Overview

This is a simple data storage project that uses a plain text file as a database. The project stores basic person records with name, age, and date of birth information in a semicolon-delimited format.

# User Preferences

Preferred communication style: Simple, everyday language.

# System Architecture

## Data Storage

**Problem:** Need to store basic person records with minimal complexity.

**Chosen Solution:** Plain text file (`db.txt`) with semicolon-delimited values.

**Format:** Each line represents a record with the structure:
```
Name;Age;Date(YYYY-MM-DD)
```

**Pros:**
- Extremely simple to read and modify
- No database setup required
- Human-readable without special tools
- Lightweight and portable

**Cons:**
- No data validation or type safety
- No querying capabilities
- Not suitable for concurrent access
- No relational data support
- Manual parsing required

## Data Schema

Current fields per record:
1. **Name** - String identifier for the person
2. **Age** - Numeric age value
3. **Birth Date** - Date in ISO format (YYYY-MM-DD)

# External Dependencies

This project currently has no external dependencies. It uses only a flat file for data storage with no third-party services, APIs, or database systems.

If the project grows, consider:
- Adding a proper database (SQLite for simplicity, or PostgreSQL for scalability)
- Using an ORM like Drizzle for type-safe database access
- Implementing proper data validation