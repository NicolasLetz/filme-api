CREATE TABLE filmes.detalhe_filme
(
  imdbid character varying(500) NOT NULL,
  title character varying(500) NOT NULL,
  year character varying(500) NOT NULL,
  released character varying(500) NOT NULL,
  runtime character varying(500) NOT NULL,
  genre character varying(500) NOT NULL,
  director character varying(500) NOT NULL,
  writer character varying(500) NOT NULL,
  actors character varying(500) NOT NULL,
  plot character varying(500) NOT NULL,
  language character varying(500) NOT NULL,
  country character varying(500) NOT NULL,
  poster character varying(500) NOT NULL,
  imdb_rating character varying(500) NOT NULL,
  imdb_votes character varying(500) NOT NULL,
  response character varying(500) NOT NULL,
  CONSTRAINT detalhe_filme_pkey PRIMARY KEY (imdbid)
)

CREATE TABLE filmes.filme
(
  imdbid character varying(500) NOT NULL,
  title character varying(500) NOT NULL,
  year character varying(500) NOT NULL,
  type character varying(500) NOT NULL,
  poster character varying(500) NOT NULL,
  total_results character varying(500) NOT NULL,
  response character varying(500) NOT NULL,
  CONSTRAINT filme_pkey PRIMARY KEY (imdbid)
)