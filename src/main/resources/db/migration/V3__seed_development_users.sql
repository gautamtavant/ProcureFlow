INSERT INTO app_user (
    email,
    password_hash,
    display_name,
    is_active
)
VALUES (
           'requester@procureflow.test',
           '$2a$10$LuUKbqjSTUguYducyT8hee5OCeyN/5qrvnOCOIIJaLdBWwfr202tq',
           'Test Requester',
           TRUE
       );