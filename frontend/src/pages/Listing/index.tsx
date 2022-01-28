import axios from 'axios';
import { useEffect, useState } from 'react';
import MovieCard from 'components/MovieCard/index';
import Pagination from 'components/Pagination/index';
import { BASE_URL } from 'utils/requests';
import { MoviePage } from 'types/movie';

function Listing() {

  //useState(): Manter estado no componente
  const [pageNumber, setPageNumber] = useState(0);

  //estado que guarda a página que buscou na requisição
  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true
  });

  //useEffect(): Executar algo na instanciação ou destruição do componente, observar estado
  //executa a função useEffect, somente quando carregar o componente
  //executando detro de um hooks, que amarra dentro do ciclo de vida do componente
  //parâmetro de ordenação - sort=id - a ordem da busca vem por id, por exemplo...title...
  useEffect(() => {
    axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
      .then(response => {
        const data = response.data as MoviePage;
        setPage(data);
      });
  }, [pageNumber]);//agora, o useEffect depende do pageNumber. Qdo mudar o pageNumber, refazer a requisição e atualizar a página novamente

  return (
    <>
      <Pagination />

      <div className='container'>
        <div className='row'>
          {page.content.map(movie => (
            //em uma renderização dinâmica de coleção, cada elemento renderizado DEVE possuir um atributo key
            <div key={movie.id} className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
              <MovieCard movie={movie} />
            </div>
          )
          )}
        </div>
      </div>
    </>
  )
}

export default Listing;