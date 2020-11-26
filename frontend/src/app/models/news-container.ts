import { News } from './news';

export interface NewsContainer {
    country: string,
    category: string,
    articles: News[]
}
