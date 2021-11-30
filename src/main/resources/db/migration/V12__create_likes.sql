CREATE TABLE likes (
                       likesID uuid PRIMARY KEY,
                       likes integer,
                       postID uuid references posts(postID)
);
