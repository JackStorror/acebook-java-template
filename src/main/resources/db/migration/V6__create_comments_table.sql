ALTER TABLE posts ADD COLUMN users INTEGER references users(id);

CREATE TABLE comments (
                       id bigserial PRIMARY KEY,
                       username varchar(50) NOT NULL references users(username),
                       content varchar(250) NOT NULL,
                       ref_post_id integer NULL references posts(id)
);