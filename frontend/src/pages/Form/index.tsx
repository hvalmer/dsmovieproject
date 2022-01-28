import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';

function Form() {

  //pegando o id
  const params = useParams();

  return (
    <FormCard movieId={`${params.movieId}`}/>
  );
}

export default Form;