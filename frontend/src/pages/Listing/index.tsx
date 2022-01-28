import axios from 'axios';
import { useEffect, useState } from 'react';
import MovieCard from 'components/MovieCard/index';
import Pagination from 'components/Pagination/index';
import { BASE_URL } from 'utils/requests';
import { MoviePage } from 'types/movie';

function Listing() {

  const [pageNumber, setPageNumber] = useState(0);

  //executa a função useEffect, somente quando carregar o componente
  //executando detro de um hooks, que amarra dentro do ciclo de vida do componente
  useEffect(() => {
    axios.get(`${BASE_URL}/movies?size=12&page=1`)
    .then(response => {
      const data = response.data as MoviePage;
      console.log(data);  
      setPageNumber(data.number);
     });
  
  }, []);

  return (
    <>
      <p>{pageNumber}</p>
      <Pagination />

      <div className='container'>
        <div className='row'>
          <div className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
            <MovieCard />
          </div>
          <div className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
            <MovieCard />
          </div>
          <div className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
            <MovieCard />
          </div>
          <div className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
            <MovieCard />
          </div>
          <div className='col-sm-6 col-lg-4 col-xl-3 mb-3'>
            <MovieCard />
          </div>
          
        </div>
      </div>

    </>
  )
}

export default Listing;