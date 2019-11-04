import React, { Component } from 'react';
import Blogpost from './Blogpost';
import PropTypes from 'prop-types';

class Blogposts extends Component {
	render() {
			return this.props.posts.map((post) => (
				<Blogpost key={post.id} post={post}/>
			));
	}
}

Blogposts.propTypes = {
	blogposts: PropTypes.array.isRequired
}

export default Blogposts;
