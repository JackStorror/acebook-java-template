CREATE TABLE likes (
                       likesID uuid PRIMARY KEY,
                       likes integer,
                       postID uuid references posts(postID),
                       userID uuid references users(userID),
                       username VARCHAR(50) NOT NULL references users(username)
);
