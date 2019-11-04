import React, { Component } from 'react';
import PropTypes from 'prop-types';

class Blogpost extends Component {
	render () {
		return (
			<div className="Blogpost">
				<h3>{this.props.post.title}</h3>
				<p>{this.props.post.body}</p>
			</div>
		)
	}
}

Blogpost.propTypes = {
	post: PropTypes.object.isRequired
}
	

export default Blogpost;
