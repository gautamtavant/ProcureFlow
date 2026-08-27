INSERT INTO user_role (
    user_id,
    role_id
)
SELECT
    app_user.id,
    role.id
FROM app_user
         CROSS JOIN role
WHERE app_user.email = 'requester@procureflow.test'
  AND role.code = 'REQUESTER';